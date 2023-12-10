const gulp        = require('gulp');
const browserSync = require('browser-sync').create();
const sass        = require('gulp-sass');

// Compile Sass & Inject Into Browser
gulp.task('sass', function() {
//   return gulp.src(['node_modules/bootstrap/scss/bootstrap.scss', 'src/scss/*.scss','src/scss/*'])
  return gulp.src(['src/scss/cats.scss'])
    .pipe(sass())        
    .pipe(gulp.dest("dist/css"))
.pipe(gulp.dest("cat_dog/public/css"))
        .pipe(browserSync.stream());
});

// Move JS Files to src/js
gulp.task('js', function() {
    return gulp.src(['node_modules/bootstrap/dist/js/bootstrap.min.js', 'node_modules/jquery/dist/jquery.min.js','node_modules/popper.js/dist/umd/popper.min.js','src/js/cats.js']) 
.pipe(gulp.dest("cat_dog/public/js"))
        .pipe(browserSync.stream());
});

// Watch Sass & Serve
gulp.task('serve', ['sass'], function() { 
    browserSync.init({
        server: "./"  
    });

    gulp.watch(['node_modules/bootstrap/scss/bootstrap.scss','src/scss/*.css', 'src/scss/*.scss'], ['sass']);
    gulp.watch("/*.html").on('change', browserSync.reload);
});

// Move Fonts to src/fonts
gulp.task('fonts', function() {
  return gulp.src('node_modules/font-awesome/fonts/*')
    
.pipe(gulp.dest('cat_dog/public/fonts'))
})

// Move Font Awesome CSS to src/css
gulp.task('fa', function() {
  return gulp.src('node_modules/font-awesome/css/font-awesome.min.css')
    
.pipe(gulp.dest('cat_dog/public/css'))
})
// 'serve'
gulp.task('default', ['sass','js', 'fa', 'fonts']);
