package com.Abdul.Medium.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



public class ResourceNoutFoundException extends  RuntimeException
{
    String resourceName;
    String fieldName;
    long fieldValue;

    public ResourceNoutFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s ACHHHA Theek  H SAMAJH GYA  %s :%s",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }


    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public long getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(long fieldValue) {
        this.fieldValue = fieldValue;
    }
}
