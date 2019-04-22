/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sci.view;

import javax.servlet.ServletContext;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.config.Direction;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.Path;
import org.ocpsoft.rewrite.servlet.config.Redirect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 *
 * @author mocbezerra
 */
@Component
@ApplicationScope
public class MyRoutes extends HttpConfigurationProvider {

	@Override
	public Configuration getConfiguration(ServletContext t) {
		return ConfigurationBuilder.begin()
			.addRule()
			.when(Direction.isInbound()
                        .and(Path.matches("/")))
			.perform(Redirect.temporary("/hello.jsf"));
	}

	@Override
	public int priority() {
		return 10;
	}
}