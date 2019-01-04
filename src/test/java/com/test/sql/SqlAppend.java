package com.test.sql;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sys.util.AssertUtils;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public interface SqlAppend {


    SqlAppend append(Object obj);


}