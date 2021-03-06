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

import org.rapidpm.dependencies.core.logger.LogEvent;
import org.rapidpm.dependencies.core.logger.LoggingService;

/**
 * <p>NoLogFactory class.</p>
 *
 * @author svenruppert
 * @version $Id: $Id
 */
public class NoLogFactory implements LoggerFactory {
  final LoggingService noLogger = new NoLogger();

  /** {@inheritDoc} */
  @Override
  public LoggingService getLogger(String name) {
    return noLogger;
  }

  static class NoLogger implements LoggingService {
    @Override
    public void finest(String message) {
    }

    @Override
    public void finest(String message , Throwable thrown) {
    }

    @Override
    public void finest(Throwable thrown) {
    }

    @Override
    public boolean isFinestEnabled() {
      return false;
    }

    @Override
    public void fine(String message) {
    }

    @Override
    public boolean isFineEnabled() {
      return false;
    }

    @Override
    public void info(String message) {
    }

    @Override
    public void severe(String message) {
    }

    @Override
    public void severe(Throwable thrown) {
    }

    @Override
    public void severe(String message , Throwable thrown) {
    }

    @Override
    public void warning(String message) {
    }

    @Override
    public void warning(Throwable thrown) {
    }

    @Override
    public void warning(String message , Throwable thrown) {
    }

    @Override
    public void log(Level level , String message) {
    }

    @Override
    public void log(Level level , String message , Throwable thrown) {
    }

    @Override
    public void log(LogEvent logEvent) {
    }

    @Override
    public Level getLevel() {
      return Level.OFF;
    }

    @Override
    public boolean isLoggable(Level level) {
      return false;
    }
  }
}
