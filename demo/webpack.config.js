'use strict';

var path = require("path");
var webpack = require('webpack');
var CommonsChunkPlugin = webpack.optimize.CommonsChunkPlugin;

module.exports = {

    entry: {
        index: './bundles/index.js',
        elemental_ui: './bundles/elemental-ui.js',
        material_ui: './bundles/material-ui.js',
        semantic_ui: './bundles/semantic-ui.js',
        react_tags_input: './bundles/react-tags-input.js',
        react_select: './bundles/react-select.js',
        react_geom_icons: './bundles/react-geom-icons.js',
        react_infinite: './bundles/react-infinite.js',
        react_spinner: './bundles/react-spinner.js',
        react_slick: './bundles/react-slick.js',
        react_split_pane: './bundles/react-split-pane.js',
        demoApp: './bundles/demo-opt.js'
    },

    output: {
        path: path.resolve(__dirname, '/assets'),
        publicPath: "/assets/",
        filename: '[name]-bundle.js'
    },

    devServer: {
        port: 8090,
        clientLogLevel: "info"
    },

    plugins: [
        new webpack.NoEmitOnErrorsPlugin(),
        new CommonsChunkPlugin({
            name: "index"
        })
    ],

    module: {
        loaders: [
            {
                test: /\.css$/,
                use: [
                  {
                    loader: 'style-loader'
                  },
                  {
                    loader: 'css-loader'
                  }
                ]
            },
            {
                test: /\.(png|jpg|svg)$/,
                use: [
                  {
                    loader: 'url-loader',
                    options: {
                      query: {
                        limit: '8192'
                      }
                    }
                  },
                  {
                    loader: 'image-webpack-loader',
                    options: {
                      query: {
                        mozjpeg: {
                          progressive: true
                        },
                        gifsicle: {
                          interlaced: true
                        },
                        optipng: {
                          optimizationLevel: 7
                        }
                      }
                    }
                  }
                ]
            } // inline base64 URLs for <=8k images, direct URLs for the rest
        ]
    }
};