package com.courses.spalah.Service;

import com.google.gson.*;
import home12.Core.Car;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Leonid on 14.04.2016.
 */
public class CarsDeserializer implements JsonDeserializer<List<Car>> {
    @Override
    public List<Car> deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        List<Car> result = new ArrayList<>();

        JsonObject jsonObject = json.getAsJsonObject();

        for(Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            Car dwarf = context.deserialize(entry.getValue(), Car.class);
            result.add(dwarf);
        }
        return result;
    }
}
