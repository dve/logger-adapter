/**
 * Copyright © 2017 Sven Ruppert (sven.ruppert@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.rapidpm.dependencies.core.logger.factory;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.rapidpm.dependencies.core.logger.AbstractLogger;
import org.rapidpm.dependencies.core.logger.LogEvent;
import org.rapidpm.dependencies.core.logger.LoggerFactorySupport;
import org.rapidpm.dependencies.core.logger.LoggingService;

/**
 * <p>StandardLoggerFactory class.</p>
 *
 * @author svenruppert
 * @version $Id: $Id
 */
public class StandardLoggerFactory extends LoggerFactorySupport implements LoggerFactory {

  /** {@inheritDoc} */
  @Override
  protected LoggingService createLogger(String name) {
    final Logger l = Logger.getLogger(name);
    return new StandardLogger(l);
  }

  static class StandardLogger extends AbstractLogger {
    private final Logger logger;

    public StandardLogger(Logger logger) {
      this.logger = logger;
    }

    @Override
    public void log(Level level , String message) {
      log(level , message , null);
    }

    @Override
    public void log(Level level , String message , Throwable thrown) {
      LogRecord logRecord = new LogRecord(level , message);
      logRecord.setLoggerName(logger.getName());
      logRecord.setThrown(thrown);
      logRecord.setSourceClassName(logger.getName());
      logger.log(logRecord);
    }

    @Override
    public void log(LogEvent logEvent) {
      logger.log(logEvent.getLogRecord());
    }

    @Override
    public Level getLevel() {
      return logger.getLevel();
    }

    @Override
    public boolean isLoggable(Level level) {
      return logger.isLoggable(level);
    }
  }
}
