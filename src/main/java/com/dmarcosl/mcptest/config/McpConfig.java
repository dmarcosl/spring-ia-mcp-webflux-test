package com.dmarcosl.mcptest.config;

import com.dmarcosl.mcptest.tools.DemoTools;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpConfig {

  @Bean
  public ToolCallbackProvider demoToolCallbacks(DemoTools demoTools) {
    return MethodToolCallbackProvider.builder().toolObjects(demoTools).build();
  }
}
