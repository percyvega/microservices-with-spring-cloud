package com.percyvega.mwsc;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Application {

  public static void main(String[] args) {
    String arg = args.length > 0 ? args[0] : "World";
    log.info("Hello, {}!", arg);
  }

}
