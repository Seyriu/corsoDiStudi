/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.exceptions;

/**
 *
 * @author Utente
 */
public class CDSException extends Exception {

  public CDSException() {
  }

  public CDSException(String message) {
    super(message);
  }

  public CDSException(String message, Throwable cause) {
    super(message, cause);
  }

  public CDSException(Throwable cause) {
    super(cause);
  }

  public CDSException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
  
}
