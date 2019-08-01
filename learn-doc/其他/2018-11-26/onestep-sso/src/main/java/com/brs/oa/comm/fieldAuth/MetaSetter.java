package com.brs.oa.comm.fieldAuth;
import java.util.List;

public interface MetaSetter {
    void setMeta(List <FieldSchema> fieldSchemas);
    List<FieldSchema> getMeta();

}
