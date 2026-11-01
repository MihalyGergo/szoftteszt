function Converter(num){
    if(!Number.isInteger(num)){
        return "NAN";
    }
    if(num <= 0){
        return "NAN";
    }
    if(num >= 4000){
        return "NAN";
    }

    const values = [1, 5, 10, 50, 100, 500, 1000];
    const symbols = ["I", "V", "X", "L", "C", "D", "M"];

    let result = "";

    for(let i = 0; i < values.length; i++){
        if(num == values[i]){
            result += symbols[i];
        }
    }
    return result;
}

module.exports = { Converter };