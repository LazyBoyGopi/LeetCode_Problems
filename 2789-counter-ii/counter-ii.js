/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let org = init;
    let object = {
        increment:function(){
            return ++init;
        },
        decrement : function(){
            return --init;
        },
        reset : function(){
            init = org;
            return init;
        }
    }
    return object;
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */