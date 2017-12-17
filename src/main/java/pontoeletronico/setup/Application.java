package pontoeletronico.setup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@ComponentScan({ "pontoeletronico" })
@EntityScan("pontoeletronico.entity")
@EnableJpaRepositories("pontoeletronico.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	/// * @Bean
	// DataSource dataSource() throws SQLException {
	//
	// OracleDataSource dataSource = new OracleDataSource();
	// dataSource.setUser("smsl");
	// dataSource.setPassword("301091");
	// dataSource.setURL("jdbc:oracle:thin:@localhost:1522:xe");
	// dataSource.setImplicitCachingEnabled(true);
	// dataSource.setFastConnectionFailoverEnabled(true);
	// return (DataSource) dataSource;
	// }*/

}