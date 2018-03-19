package org.k9.archive
import org.k9.*

class Artifacts implements Serializable {
  def config
  def script

  Artifacts(script,config) {
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
  void createArchive(){
  this.script.stage('archive'){
  this.script.sh "archive 'target/*.war'"
  }
  }
}
