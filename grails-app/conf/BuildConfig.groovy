grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
        excludes 'xerces', 'xml-apis'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        //mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.13'
    }
    plugins {
        build(":tomcat:$grailsVersion", ":hibernate:$grailsVersion") {
            export = false
        }
        build ':release:2.2.1', ':rest-client-builder:1.0.3', {
            export = false
        }

        runtime ":jquery:1.7.1"
        runtime ":resources:1.2.RC3"
        compile ":fields:1.3" 
        compile ":platform-ui:1.0.RC2"
        runtime(":less-resources:1.3.3.2") {
            excludes 'svn'
        }
        runtime ":twitter-bootstrap:2.3.0"
    }
}
