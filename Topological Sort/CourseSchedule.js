var CourseSchedule=function(numCourses,prerequisites){
    let coursesTaken = 0;
    let queue = [];
    let graph = new Map();
    let hash = Array(numCourses).fill(0);
  
    for (let [course, prereq] of prerequisites) {
      if (graph.has(prereq)) graph.get(prereq).push(course);
      else graph.set(prereq, [course]);
      hash[course]++;
    }
  
    for (let course = 0; course < hash.length; course++) {
      if (hash[course] == 0) queue.push(course);
    }
  
    while (queue.length) {
      let course = queue.shift();
      if (graph.has(course)) {
        for (let c of graph.get(course)) {
          hash[c]--;
          if (hash[c] == 0) queue.push(c);
        }
      }
      coursesTaken++;
    }
    return numCourses == coursesTaken;
};
const numCourses=2;
const perscipts=[[1,0]];
const result=CourseSchedule(numCourses,perscipts);
console.log(result);