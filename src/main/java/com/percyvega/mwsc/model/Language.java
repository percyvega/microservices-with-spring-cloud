package com.percyvega.mwsc.model;

public enum Language {
  Spanish("Spanish"),
  English("English"),
  Portuguese("Portuguese"),
  French("French");

  private String name;

  Language(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
