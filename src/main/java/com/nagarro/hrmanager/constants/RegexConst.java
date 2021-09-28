package com.nagarro.hrmanager.constants;

/**
 * <p>This class contains Regex String for matching pattern with Flight details</p>
 */
public class RegexConst {
    public static final String FLIGHT_NO_REGEX = "[a-zA-Z0-9]+";
    public static final String LOCATION_REGEX = "[a-zA-Z]{3}";
    public static final String VALID_TILL_DATE_REGEX = "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[0-2])-([0-9]{4})"  ;
    public static final String VALID_TILL_DATE_REGEX_SPECIAL = "[0-9][-]*"  ;
    public static final String FLIGHT_TIME_REGEX =   "([01]?[0-9]|2[0-3])[0-5][0-9]";
    public static final String FLIGHT_DURATION_REGEX =  "([0-9]*[.])?[0-9]+";
    public static final String FLIGHT_FARE_REGEX = "[0-9]+" ;
    public static final String YES_NO_REGEX = "([Y|N]|[y|n]){1}" ;
    public static final String YES_REGEX = "[Y|y]{1}" ;
    public static final String FLIGHT_CLASS_REGEX = "([E|B]|[e|b]){1,2}";
    public static final String OUTPUT_PREFERENCE_REGEX = "[1|2]{1}";
    public static final String FIND_FLIGHT_CODE_SYMBOL = "[F|f]{1}";
}