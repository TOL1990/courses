package com.courses.spalah.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import home12.Core.Owner;

import java.lang.reflect.Type;

/**
 * Created by Leonid on 14.04.2016.
 */
public class OwnerSerializer  implements JsonSerializer<Owner>
{
    @Override
    public JsonElement serialize(Owner src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();

        result.addProperty("name", src.getFirstName());
        result.addProperty("surname", src.getLastName());
        result.addProperty("mobile_phone", src.getTel());
        return result;
    }

}
