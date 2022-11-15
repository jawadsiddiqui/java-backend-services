package com.designpatterns.singleton;

public class DBSingletonThreadSafe {

  private static volatile DBSingletonThreadSafe instance = null;

  private DBSingletonThreadSafe(){
      if(instance!=null) throw new RuntimeException("Use getIntance() method to create");
  }

    public DBSingletonThreadSafe getInstance() {
      if(instance == null ) {
          synchronized (DBSingletonThreadSafe.class) {
             if (instance == null) instance = new DBSingletonThreadSafe();
          }
      }
      return instance;
    }
}
