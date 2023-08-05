package esperer.appjam.global.config

import esperer.appjam.global.security.token.JwtProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationPropertiesScan(basePackageClasses = [ JwtProperties::class ])
class PropertiesScanConfiguration