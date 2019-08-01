package com.brs.oa.comm.fieldAuth;


import java.util.List;
import java.util.function.Function;

public class FilterableResult<T> implements Filterable<T>,MetaSetter {

    private List<T>rows;
    private List<FieldSchema> meta;


    private FilterableResult(List rows) {
        this.rows = rows;
    }


    @Override
    public void doFilter(Function<T, T> filterFunction) {
        for (T row :rows){
            filterFunction.apply(row);
        }

    }

    @Override
    public void setMeta(List<FieldSchema> dataResources) {
               this.meta =dataResources;
    }

    @Override
    public List <FieldSchema> getMeta() {
        return this.meta;
    }

     public static FilterableResult build(List rows){
       return  new FilterableResult(rows);
     }

    public List <T> getRows() {
        return rows;
    }

    public void setRows(List <T> rows) {
        this.rows = rows;
    }



}
