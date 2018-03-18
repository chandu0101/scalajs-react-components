module.exports = {
  "entry": {
    "scalajs-react-components-demo-opt": ["/home/olvind/pr/scalajs-react-components/demo/target/scala-2.12/scalajs-bundler/main/scalajs-react-components-demo-opt-entrypoint.js"]
  },
  "output": {
    "path": "/home/olvind/pr/scalajs-react-components/demo/target/scala-2.12/scalajs-bundler/main",
    "filename": "[name]-library.js",
    "library": "ScalaJSBundlerLibrary",
    "libraryTarget": "var"
  },
  "devtool": "source-map",
  "module": {
    "rules": [{
      "test": new RegExp("\\.js$"),
      "enforce": "pre",
      "loader": "source-map-loader"
    }]
  }
}