String basePath = 'example2'
String repo = 'sheehan/grails-example'

folder(basePath) {
    description 'This example shows basic folder/job creation.'
}

job("$basePath/grails example2 build") {
    scm {
        github repo
    }
    triggers {
        scm 'H/5 * * * *'
    }
    steps {
        grails {
            useWrapper true
            targets(['test-app', 'war'])
        }
    }
}

job("$basePath/grails example2 deploy") {
    parameters {
        stringParam 'host'
    }
    steps {
        shell 'scp war file; restart...'
    }
}
