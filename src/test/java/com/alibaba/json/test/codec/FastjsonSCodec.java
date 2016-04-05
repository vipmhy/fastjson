package com.alibaba.json.test.codec;

import java.lang.reflect.Type;
import java.util.Collection;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastjsonSCodec implements Codec {
    public String getName() {
        return "fastjsonS";
    }

    // fastjson 模拟首次
    public <T> T decodeObject(String text, Type clazz) {
        return JSON.parseObject(text, // 
                                clazz, //
                                new ParserConfig(), // 每次new ParserConfig模拟首次
                                JSON.DEFAULT_PARSER_FEATURE, // 
                                Feature.DisableCircularReferenceDetect);
    }
    
    public String encode(Object object) throws Exception {
        return JSON.toJSONString(object, // 
                                 new SerializeConfig(), // 每次new SerializeConfig模拟首次
                                 SerializerFeature.DisableCircularReferenceDetect);
    }
    
    public <T> Collection<T> decodeArray(String text, Class<T> clazz) throws Exception {
        throw new RuntimeException("TODO");
    }

    public final Object decodeObject(String text) {
        throw new RuntimeException("TODO");
    }

    public final Object decode(String text) {
        throw new RuntimeException("TODO");
    }
    
    public <T> T decodeObject(byte[] input, Type clazz) throws Exception {
        throw new UnsupportedOperationException();
    }

}
