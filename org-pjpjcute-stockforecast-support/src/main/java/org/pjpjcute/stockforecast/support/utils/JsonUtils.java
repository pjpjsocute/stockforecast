package org.pjpjcute.stockforecast.support.utils;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Json转换工具类
 */
@Slf4j
public final class JsonUtils {
    @Getter
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    // 将 JSON 字符串基于 Class 转换为对象
    public static <T> T deserialize(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON string: " + json, e);
        }
    }

    public static <T> T deserialize(String obj, TypeReference<T> typeRef) {
        if (Objects.isNull(obj)) {
            return null;
        }
        try {
            return objectMapper.readValue(obj, typeRef);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 将 JSON 字符串转换为相应泛型的 List
    public static <T> List<T> jsonToList(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return objectMapper.readValue(json,
                objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON string: " + json, e);
        }
    }

    // 将 JSON 字符串转换为相应泛型的 List
    public static <T> List<T> jsonToList(Object json, Class<T> clazz) {
        if (json == null) {
            return null;
        }
        try {
            return objectMapper.convertValue(json,
                objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON string: " + json, e);
        }
    }

    // 将一个对象转换为 JSON 字符串
    public static String serialize(Object obj) {
        if (Objects.isNull(obj)) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting object to JSON string: " + obj, e);
        }
    }

    // 将一个对象转换为 cams的列表格式
    public static String serialize2CamsList(List<String> obj) {
        if (CollectionUtils.isEmpty(obj)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : obj) {
            sb.append(s + ",");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    // 将 Object 对象转换为对应的泛型对象
    public static <T> T deserialize(Object obj, Class<T> clazz) {
        if (Objects.isNull(obj)) {
            return null;
        }
        try {
            return objectMapper.convertValue(obj, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // 将 Object 对象中的string转泛型
    public static <T> T parseObjStringToObj(Object obj, Class<T> clazz) {
        if (Objects.isNull(obj)) {
            return null;
        }
        try {
            String input = obj.toString();
            return deserialize(input, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // 之前的 parse 方法，将 JSON 字符串基于 TypeReference 转换为对象
    public static <T> T parse(String json, TypeReference<T> typeReference) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return objectMapper.readValue(json, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON string: " + json, e);
        }
    }

    // 之前的 parse 方法，将 JSON 字符串基于 TypeReference 转换为对象
    public static <T> T parse(String json, Type typeReference) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            JavaType javaType = objectMapper.constructType(typeReference);
            return objectMapper.readValue(json, javaType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON string: " + json, e);
        }
    }

    // = 用于解析Eco的参数
    public static <T> T parseEcoResp(String json, Type typeReference, Method method) {
        try {
            JavaType javaType = objectMapper.constructType(typeReference);
            JsonNode rootNode = objectMapper.readTree(json);

            JsonNode dataNode = rootNode.path("data");
            if (dataNode.isTextual()) {
                // data 字段是被转义的 JSON 字符串，需要进行解码
                String dataJson = dataNode.asText();
                JavaType innerType = objectMapper.constructType(resolveDataTypeFromMethod(method));
                return objectMapper.readValue(dataJson, innerType);
            } else {
                // data 字段已经是一个 JSON 对象或数组，直接反序列化
                return objectMapper.readValue(rootNode.traverse(), javaType);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON string: " + json, e);
        }
    }

    // = 用于解析Eco的参数
    public static <T> T parseEcoResp(String json, Type typeReference) {
        try {
            JavaType javaType = objectMapper.constructType(typeReference);
            JsonNode rootNode = objectMapper.readTree(json);

            JsonNode dataNode = rootNode.path("data");

            if (dataNode.isTextual()) {
                // data 字段是被转义的 JSON 字符串，需要进行解码
                String dataJson = dataNode.asText();
                JsonNode jsonNode = objectMapper.readTree(dataJson);
                ((ObjectNode)rootNode).set("data", jsonNode);

                return objectMapper.readValue(rootNode.traverse(), javaType);
            } else {
                // data 字段已经是一个 JSON 对象或数组，直接反序列化
                return objectMapper.readValue(rootNode.traverse(), javaType);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON string: " + json, e);
        }
    }

    public static Type resolveDataTypeFromMethod(Method method) {
        Type genericReturnType = method.getGenericReturnType();

        // 检查返回类型是否为 ParameterizedType
        if (genericReturnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)genericReturnType;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();

            // 假设第一个类型参数是 "data" 字段的实际类型
            if (typeArguments.length > 0) {
                return typeArguments[0];
            }
        }

        return null;
    }

}
