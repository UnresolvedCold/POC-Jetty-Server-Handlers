package com.schwiftycold.poc.jettypoc;

import java.io.FileInputStream;


public enum Properties {
  SERVERPORT("SERVERPORT", "9210");

  private String key;
  private String value;


    static {
    java.util.Properties prop = new java.util.Properties();
    try {
      prop.load(new FileInputStream("config/simulation.properties"));
    } catch (Exception e) { }
    for (Properties property : Properties.values()) {
      if (prop.containsKey(property.key)) {
        property.value = prop.getProperty(property.key);
      }
    }
  }

  private Properties(String key, String value) {
    this.key = key;
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public int getIntegerValue() {
    return Integer.parseInt(value);
  }

  public double getDoubleValue() {
    return Double.parseDouble(value);
  }

  public boolean getBooleanValue() {
    return Boolean.parseBoolean(value);
  }

}
