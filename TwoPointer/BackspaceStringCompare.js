var BackspaceStringCompare=function(s,t){
    let sleng=s.length-1;
    let tleng=t.length-1;
    while(sleng>=0||tleng>=0){
        let skip=0;
        while(sleng>=0){
            if(s.charAt(sleng)==="#"){
                skip++;
                sleng--;
            }else if(skip>0){
                skip--;
                sleng--;
            }else{
                break;
            }
        }
        let tkip=0;
        while(tleng>=0){
            if(t.charAt(tleng)==="#"){
                tkip++;
                tleng--;
            }else if(tkip>0){
                tkip--;
                tleng--;
            }else{
                break;
            }
        }
        if(sleng>=0&&tleng>=0&&s.charAt(sleng)==t.charAt(tleng)){
            sleng--;
            tleng--;
        }else{
            return sleng===-1&&tleng===-1;
        }
    }
    return true;

};
const s="ab#c";
const t="ad#c";
const result=BackspaceStringCompare(s,t);
console.log(result);

