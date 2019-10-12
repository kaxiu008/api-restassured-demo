#!/usr/bin/env groovy

@Library('olb-pipeline-utils')


def module = moduleJob(this)

module.buildNode({
    properties([buildDiscarder(logRotator(numToKeepStr: '5'))])

    checkout scm
    try {
        stage('Integration Tests') {
            module.build('test')
        }

        stage('Reporting') {
            module.reportJunit()

            if (currentBuild.result == 'ERROR' || currentBuild.result == 'FAILURE') {
                println "${currentBuild.result} -- ${currentBuild.description}"

                error "There are current build errors, unable to continue ${currentBuild.description}";
            }
        }

        stage('Finish') {
            cleanWs()
            if (currentBuild.result == null || currentBuild.result == '') {
                currentBuild.result = 'SUCCESS'
            }
        }
    } finally {
        notifyFlowdock('939c310a866d0254dcf38697f493e')
    }
})
