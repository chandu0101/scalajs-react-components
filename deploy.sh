#!/bin/sh


# get comment
comment="$1"

if [ "$comment" == "" ]; then
comment="push form CI"
echo "no comment specified to deploy, using default : $comment"
fi


sbt fullOptJS

ghPagesPath="/Users/chandrasekharkode/Desktop/Kode/Programming/scalaprojects/chandu0101.github.io"

projectPath=$ghPagesPath/sjrc

cp demo/index.html $projectPath

cp -r demo/js $projectPath/js

cp -r demo/styles $projectPath/styles

cp -r demo/font $projectPath/font

cp -r demo/images $projectPath/images

cp -r core/docs $projectPath/docs

cd $ghPagesPath

git add sjrc

git commit -a -m "$comment"

git push