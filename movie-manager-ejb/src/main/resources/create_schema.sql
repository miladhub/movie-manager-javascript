drop user movie;
drop schema movie;
create user movie identified by 'movie';
create schema movie;
grant all privileges on movie.* to movie;
