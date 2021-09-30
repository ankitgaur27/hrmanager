pipeline {
  agent any
  stages {

  stage('Maven Installation')
    {
    steps{
        echo "Building the checked out project...";
        bat "mvn clean install";
        }
    }
    stage('Deployment Stage')
  {
	    steps
	    {
	      withMaven(maven : 'Maven3.8.2')
	    {
		    sh 'mvn deploy'
	    }
  }

}
}
}
