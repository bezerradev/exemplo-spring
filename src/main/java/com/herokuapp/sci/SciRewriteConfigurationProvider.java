package com.herokuapp.sci;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.servlet.ServletContext;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;

import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

@Named
@ApplicationScoped
public class SciRewriteConfigurationProvider extends HttpConfigurationProvider {

    @Override
    public int priority() {
        return 10;
    }

    @Override
    public Configuration getConfiguration(ServletContext t) {
        return ConfigurationBuilder.begin()
                .addRule(Join.path("/adicionarMensagem").to("mensagemAdicionar.jsf"))
                .addRule(Join.path("/listarMensagem").to("mensagemListar.jsf"))
                .addRule(Join.path("/adicionarDestinatario").to("destinatarioAdicionar.jsf"))
                .addRule(Join.path("/listarDestinatario").to("destinatarioListar.jsf"))
                .addRule(Join.path("/adicionarFiltro").to("filtroAdicionar.jsf"))
                .addRule(Join.path("/listarFiltro").to("filtroListar.jsf"))
                .addRule(Join.path("/updateFiltro").to("filtroUpdate.jsf"))
                .addRule(Join.path("/").to("index.jsf"));

    }
}
