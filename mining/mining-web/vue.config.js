const CompressionWebpackPlugin = require('compression-webpack-plugin');
const productionGzipExtensions = ['js', 'css'];
const isProduction = process.env.NODE_ENV === 'production';

module.exports = {
  runtimeCompiler: true,
  transpileDependencies: [
    'vue-echarts',
    'resize-detector'
  ],
  publicPath: './',
  devServer: {
    //proxy: 'http://localhost:2001/'
   // proxy: 'http://129.28.184.11:8081/mining-interface/'
  },
  configureWebpack: config => {
    if (isProduction) {
     config.plugins.push(new CompressionWebpackPlugin({
      algorithm: 'gzip',
      test: new RegExp('\\.(' + productionGzipExtensions.join('|') + ')$'),
      threshold: 10240,
      minRatio: 0.8
     }))
    }
   }
}