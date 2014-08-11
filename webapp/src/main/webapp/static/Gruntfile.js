module.exports = function(grunt) {

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        
        gruntMavenProperties: grunt.file.readJSON('grunt-maven.json'),
        
        concat: {
	      options: {
	        separator: ';'
	      },
	      dist: {
	        src: ['bower_components/**/*.js'],
	        dest: 'dist/<%= pkg.name %>.js'
	      }
	    },
	    
	    uglify: {
	      options: {
	        banner: '/*! <%= pkg.name %> <%= grunt.template.today("dd-mm-yyyy") %> */\n'
	      },
	      dist: {
	        files: {
	          'dist/<%= pkg.name %>.min.js': ['<%= concat.dist.dest %>']
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
		      files: ['../src/main/webapp/static/*.js'],
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

    grunt.registerTask('default', ['mavenPrepare','concat', 'uglify', 'mavenDist']);
};
