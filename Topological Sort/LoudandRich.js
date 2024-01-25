var LoudandRich=function(richer,quiet){
     // The key is poorer than all the values
  const richerMap = new Array(quiet.length)
  
  for (let i = 0; i < richerMap.length; ++i) {
    richerMap[i] = []
  }
  for (const richerPair of richer) {
    richerMap[richerPair[1]].push(richerPair[0])
  }

  // lotr stands for "loudest of the richer"
  // The values are people
  const lotr = new Array(quiet.length)

  const calculateLotr = person => {
    if (lotr[person] === undefined) {
      let loudestPerson = person
      let richerLoudestPerson
      for (const richerPerson of richerMap[person]) {
        richerLoudestPerson = calculateLotr(richerPerson)
        if (quiet[richerLoudestPerson] < quiet[loudestPerson]) {
          loudestPerson = richerLoudestPerson
        }
      }
      lotr[person] = loudestPerson
    }
    return lotr[person]
  }

  for (let i = 0; i < lotr.length; ++i) {
    calculateLotr(i)
  }
  
  return lotr
}
const richer=[[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]];
const quiet=[3,2,5,4,5,6,7];
const result=LoudandRich(richer,quiet);
console.log(result);