package com.manhee.newsapp_2020_mk.ui;

import java.lang.System;

/**
 * 'Room' only deals with primitive data-types (ie. NOT customized class)
 * So in order to deal with the customized data-type (ie. 'SOURCE' from REST-API),
 * we need to create this class that converts the CUSTOMIZED-data type into..
 * primitive data-type (ie. In this case 'String')
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/manhee/newsapp_2020_mk/ui/Converters;", "", "()V", "fromSource", "", "source", "Lcom/manhee/newsapp_2020_mk/ui/Source;", "toSource", "name", "app_debug"})
public final class Converters {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final java.lang.String fromSource(@org.jetbrains.annotations.NotNull()
    com.manhee.newsapp_2020_mk.ui.Source source) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final com.manhee.newsapp_2020_mk.ui.Source toSource(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    public Converters() {
        super();
    }
}