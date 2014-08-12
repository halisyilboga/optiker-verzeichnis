module.exports = function(grunt) {

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        
        gruntMavenProperties: grunt.file.readJSON('grunt-maven.json'),

        // copy bower components to dist
        copy: {
            main: {
                files: [
                    // flattens results to a single level
                    {expand: true, flatten: true, src: ['bower_components/**/*.map', 'bower_components/**/*min.js', 'bower_components/**/*.gzip', 'bower_components/**/*.css'], dest: 'dist/', filter: 'isFile'}
                ]
            }
        },

        // uglify all from js directory
	    uglify: {
	      options: {
	        banner: '/*! <%= pkg.name %> <%= grunt.template.today("dd-mm-yyyy") %> */\n'
	      },
	      dist: {
	        files: {
	          'dist/optiker-verzeichnis.min.js': ['js/*.js']
	        }
	      }
	    },
	    
	    mavenPrepare: {
		    options: {
		      resources: ['**']
		    },
		    prepare: {}
		},

		mavenDist: {
		    options: {
		      warName: '',
		      deliverables: ['optiker-verzeichnis.min.js'],
		      gruntDistDir: 'dist'
		    },
		    dist: {}
		},

		watch: {
		    maven: {
		      files: ['../src/main/webapp/static/**/*.js'],
		      tasks: ['default'],
		      options: {      			
    		  }
		  }
  		}
    });
  
  	grunt.loadNpmTasks('grunt-maven');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-copy');

    grunt.registerTask('default', ['mavenPrepare', 'uglify', 'copy', 'mavenDist']);
};
