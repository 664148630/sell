package com.imooc.utils.serializer;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * Created by 赖学军
 *
 * @Date 2025/5/30 13:55
 * @Version 1.0
 */
public class Date2LongSerializer extends JsonSerializer<Date> {

    /**
     * 把date 转换成 long
     * @param date
     * @param jsonGenerator
     * @param serializerProvider
     * @throws IOException
     */
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(date.getTime() / 1000);
    }
}
