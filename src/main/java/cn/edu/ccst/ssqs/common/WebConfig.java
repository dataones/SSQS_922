package cn.edu.ccst.ssqs.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // 1. 允许前端的域名（填你前端实际运行的地址，比如 Vue 启动的 http://localhost:3000）
        // 开发环境用 "*" 临时测试（生产环境必须指定具体域名）
        config.addAllowedOriginPattern("*");
        // 2. 必须开启，否则前端 withCredentials: true 会失效
        config.setAllowCredentials(true);
        // 3. 允许所有 HTTP 方法（包括 POST）
        config.addAllowedMethod("*");
        // 4. 允许所有请求头（包括 Content-Type）
        config.addAllowedHeader("*");
        // 5. 允许跨域请求的有效期（可选，避免频繁预检请求）
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 对所有接口生效（包括 /login 和 /getCurr）
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}