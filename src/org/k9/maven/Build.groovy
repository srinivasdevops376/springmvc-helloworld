package org.k9.maven
import org.k9.*

class Build implements Serializable {
  def config
  def script

  Build(script,config) {
    this.config = config
    this.script = script
  }
  
  void checkout(){    
    this.script.stage('checkout'){
        this.script.git(url: this.config.scm_url, branch: this.config.scm_branch)

    }
  
    }
    void mavenBuild(){
      this.script.stage('build'){
         this.script.sh "mvn -Dmaven.test.failure.ignore clean package"
    }
  }
}
