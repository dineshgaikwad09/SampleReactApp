libraries{
    //merge = true
    svn 
    {
        svn_global_credential1 = "svn_credential_pipeline"
        svn_repo1 = "https://svn.riouxsvn.com/dmifactory"
    }
    ant
    sonarqube
    {
        projectKey1 = "CalculatorApp"
        sonarHostUrl = "http://ec2-35-83-131-175.us-west-2.compute.amazonaws.com"

    }
    //artifactory. take reference from buildcombined.groovy
    jfrog 
    {
        artifactory_global_id = "artifactory-server"
        artifactory_url = "http://ec2-54-200-173-18.us-west-2.compute.amazonaws.com/artifactory"
        artifactory_credentials = "jfrog_credentials"
        artifactory_repo = "java_sample_app"
    }
    tomcat
    {
        tomcat_global_id = "tomcat_deployment_cred"
        tomcat_url = "bitnami@ec2-44-231-245-46.us-west-2.compute.amazonaws.com"
        tomcat_war_deploy_path = "/opt/bitnami/tomcat/webapps"
        tomcat_shutdown_path = "/opt/bitnami/tomcat/bin/shutdown.sh"
        tomcat_startup_path = "/opt/bitnami/tomcat/bin/startup.sh"
    }
}
