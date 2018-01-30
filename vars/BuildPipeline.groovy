def call (body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline {
        agent {
            node {
                label "master"
            }
        }

        stages{
            stage('Build'){
                steps{
                    echo "Build"
                }
            }
        }
    }
}