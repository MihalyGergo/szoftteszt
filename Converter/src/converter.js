function Converter(num){
    if(!Number.isInteger(num)){
        return "NAN";
    }
    if(num <= 0){
        return "NAN";
    }
    return 0;
}

module.exports = { Converter };