package com.percyvega.mwsc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

  private static final Logger logger = LogManager.getLogger("HelloWorld");

  public static void main(String[] args) {
    String arg = args.length > 0 ? args[0] : "World";
    logger.info("Hello, {}!", arg);
  }

}
