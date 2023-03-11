package com.ltms.pfe;



import ch.qos.logback.core.encoder.EchoEncoder;
import com.ltms.pfe.app.user.AppUser;
import com.ltms.pfe.app.user.AppUserRepository;
import com.ltms.pfe.app.user.AppUserRole;
import com.ltms.pfe.registration.token.ConfirmationToken;
import com.ltms.pfe.registration.token.ConfirmationTokenRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class PfeApplication {
	private final AppUserRepository appUserRepository;
	private final ConfirmationTokenRepository confirmationTokenRepository;


	public PfeApplication(AppUserRepository appUserRepository,
						  ConfirmationTokenRepository confirmationTokenRepository) {
		this.appUserRepository = appUserRepository;
		this.confirmationTokenRepository = confirmationTokenRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(PfeApplication.class, args);
	}



	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList( "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
	@Bean
	CommandLineRunner run(AppUserRepository appUserRepository) {

		return args -> {
			//rsponsable transport
			appUserRepository.save(new AppUser("wassim","omrani","omraniwassim33@gmail.com","$2a$10$1Lckw/wW.7u1GpWPXLe5NOtbHnGQRMuHc0W9NM1r7VT4lKiEDYiD.",true, AppUserRole.RESPONSABLE));
			confirmationTokenRepository.save(new ConfirmationToken());

			//ps managers
			appUserRepository.save(new AppUser("RIDHA","BEN HSSINE","ridha@leoni.com","$2a$10$1Lckw/wW.7u1GpWPXLe5NOtbHnGQRMuHc0W9NM1r7VT4lKiEDYiD.",true, AppUserRole.PS_manager));
			confirmationTokenRepository.save(new ConfirmationToken());
			appUserRepository.save(new AppUser("MOHAMED","RABAH","mohamed@leoni.com","$2a$10$1Lckw/wW.7u1GpWPXLe5NOtbHnGQRMuHc0W9NM1r7VT4lKiEDYiD.",true, AppUserRole.PS_manager));
			confirmationTokenRepository.save(new ConfirmationToken());
			appUserRepository.save(new AppUser("RIDHA","ZWABI","swabi@gmail.com","$2a$10$1Lckw/wW.7u1GpWPXLe5NOtbHnGQRMuHc0W9NM1r7VT4lKiEDYiD.",true, AppUserRole.PS_manager));
			confirmationTokenRepository.save(new ConfirmationToken());
			appUserRepository.save(new AppUser("KAMEL","MAHMOUDI","kamel@yahoo.fr","$2a$10$1Lckw/wW.7u1GpWPXLe5NOtbHnGQRMuHc0W9NM1r7VT4lKiEDYiD.",true, AppUserRole.PS_manager));
			confirmationTokenRepository.save(new ConfirmationToken());
			//RH ps
			appUserRepository.save(new AppUser("Jihene","Belaied","Jihen@yahoo.fr","$2a$10$1Lckw/wW.7u1GpWPXLe5NOtbHnGQRMuHc0W9NM1r7VT4lKiEDYiD.",true, AppUserRole.RH_PS));
			confirmationTokenRepository.save(new ConfirmationToken());
			appUserRepository.save(new AppUser("Saida","Ezzidine","Saida@gmail.com","$2a$10$1Lckw/wW.7u1GpWPXLe5NOtbHnGQRMuHc0W9NM1r7VT4lKiEDYiD.",true, AppUserRole.RH_PS));
			confirmationTokenRepository.save(new ConfirmationToken());
			appUserRepository.save(new AppUser("Hiba","Mensi","Hiba@leoni.com","$2a$10$1Lckw/wW.7u1GpWPXLe5NOtbHnGQRMuHc0W9NM1r7VT4lKiEDYiD.",true, AppUserRole.RH_PS));
			confirmationTokenRepository.save(new ConfirmationToken());
		};
	}



}
