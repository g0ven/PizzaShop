
var rootApp = angular.module('rootApp', []);

rootApp.service('Bas_store', function () {
    var bas;
    return {
        setBas: function (bask) {
            bas = bask;
        },
        getBas: function () {
            return bas;
        },
        addBas: function (id,name,price){
            var newBask={
                goodPizzaId:id,
                namePizza:name,
                pricePerPizza: price
            }
            bas.push(newBask);
        }
    }
});

rootApp.service('His_store', function(){
    var his;
    return{
        setHis: function(hist){
            //console.log("sd",hist);
            var oldHist=[];
            var newHist=[];
            for(key in hist){
                //console.log("tm",hist[key].timeOrder);
                oldHist.push(hist[key].timeOrder);
            }
            //console.log("oh",oldHist);
            for(key in oldHist){
                var date=new Date(oldHist[key]);
                var years = date.getFullYear();
                var months = date.getMonth();
                var days = date.getDate();
                var hours = date.getHours();
                var minutes = date.getMinutes();

                var goodTime= days+"."+months+"."+years+"   "+hours+":"+minutes;
                newHist.push(goodTime);
            }
            //console.log("nh",newHist);
            for(key in hist){
                hist[key].timeOrder=newHist[key];
            }
            //console.log("sdsds",hist);
            his=hist;
        },
        getHis: function(){
            return his;
        },
        inHis: function(bask){
            var hist=[];
            date = new Date();
            tempDate = date.valueOf();
            newDate = new Date(tempDate);
            for(key in bask){
            hist[key]={
                goodPizzaId:bask[key].goodPizzaId,
                namePizza:bask[key].namePizza,
                pricePerPizza:bask[key].pricePerPizza,
                timeOrder:newDate.getDate()+"."+(newDate.getMonth()+1)+"."+newDate.getFullYear()+"   "+newDate.getHours()+":"+newDate.getMinutes()
            }
            //console.log("ord", hist);
            his.push(hist[key]);
            }
        }
    }
});

rootApp.service('finalPizza_store', function(){
    var finPiz;
    return{
        setFinPiz: function(fin){
            finPiz = fin;
        },
        getFinPiz: function(){
            return finPiz;
        }
    }
})

rootApp.service('finIdPizza_store', function(){
    var finIdPiz;
    return{
        setFinIdPiz: function(fin){
            finIdPiz = fin;
        },
        getFinIdPiz: function(){
            return finIdPiz;
        }
    }
})

rootApp.service('ingred_store', function(){
    var ingred;
    return{
        setIngred: function(ingr){
            ingred = ingr;
        },
        getIngred: function(){
            return ingred;
        }
    }
})
rootApp.service('basis_store', function(){
    var basis;
    return{
        setBasis: function(bas){
            basis = bas;
        },
        getBasis: function(){
            return basis;
        }
    }
})

rootApp.service('newPizza', function(){
    var pizza={
                name:[],
                basisPizzaId:[],
                radius:[],
                ingredientsDTO:[]
            };  
    return{
        setNameAndRadius: function(namep, basisId){
            pizza={
                name:namep,
                basisPizzaId:basisId.id,
                radius:basisId.radius,
                ingredientsDTO:[]
            }
            console.log("piz",pizza);
        },
        setIngred: function(ingredId,wagep){
            var ingr={             
                id:ingredId.id,
                name:ingredId.name,
                wage:wagep
            }
            pizza.ingredientsDTO.push(ingr);
            console.log("piz",pizza);
        },
        getPizza: function(){
            return pizza;
        }
    }
})

rootApp.controller('addNewPizzaCtrl', function( $rootScope, $scope,$http,ingred_store,basis_store,newPizza, finalPizza_store){

  
  $scope.openDialogPizza = function() {
   $http.get('api/v1.0/ingredients').success(function(data){
            ingred_store.setIngred(data);
            $scope.ingredients=ingred_store.getIngred();
            
        })


   $http.get('api/v1.0/basisPizza').success(function(data){
       basis_store.setBasis(data);
       $scope.basis=basis_store.getBasis();
   })     
    
    $scope.showPopUpDialogPizza = true;
    $scope.showAddIngr=true;

  }

$scope.addNameAndRadius=function(basisId, namePizz){
    $scope.showAddIngr=false;
    console.log(basisId);
    console.log(namePizz);
    newPizza.setNameAndRadius(namePizz,basisId);
    $scope.finPizzId=newPizza.getPizza();
    
}

$scope.addIngredient=function(ingredId,wage){
    console.log(ingredId);
    console.log(wage);
    newPizza.setIngred(ingredId,wage);
    $scope.finPizzId=newPizza.getPizza();
}

$scope.finPizzId=newPizza.getPizza();

$scope.createPizza=function(){
    var sendPizza=newPizza.getPizza();
    console.log("send",sendPizza);
    $http.post("/api/v1.0/finalPizza",sendPizza);
    $http.get('api/v1.0/finalPizza').success(function (data){
        finalPizza_store.setFinPiz(data);
    })
}

$scope.closePopUpDialogPizza = function() {
        
         $scope.showPopUpDialogPizza = false;
       }


})


rootApp.controller('allFinCtrl', function ($rootScope,$scope, $http, Bas_store, finalPizza_store){
    $http.get('/api/v1.0/finalPizza').success(function(data) {
        finalPizza_store.setFinPiz(data);
        $scope.finalPizza = finalPizza_store.getFinPiz();
    });
    $scope.save=function(id,name,price){
        $http.post('api/v1.0/basket',id);
        Bas_store.addBas(id,name,price);
    }
    
});


rootApp.controller('finIdCtrl', function( $rootScope, $scope,$http, finIdPizza_store ){

  $scope.openDialog = function(id) {
      $http.get('api/v1.0/finalPizza?id='+id).success(function(data){
         finIdPizza_store.setFinIdPiz(data);
         $scope.finPizzId= finIdPizza_store.getFinIdPiz();
         //console.log($scope.finPizzId);
    })
   
    $scope.showPopUpDialog = true;

  }
$scope.closePopUpDialog = function() {
         $scope.showPopUpDialog = false;
       }


})





rootApp.controller("basCtrl",function($rootScope,$scope,$http,Bas_store,His_store){
    $http.get('/api/v1.0/basket').success(function(data){
        var baske=data;
        Bas_store.setBas(baske);
        //console.log(baske);
        $scope.basket=Bas_store.getBas();
        
    });
    $scope.removes=function(index,ids){
        $scope.basket.splice(index,1);
        $http.delete('/api/v1.0/basket?id='+ids);
    }
    $scope.order=function(bask){
        His_store.inHis(bask);

        $scope.basket.length=0;
        $http.post('/api/v1.0/history');
    }
});

rootApp.controller('hisCtrl', function($rootScope,$scope,$http,His_store){
    $http.get('/api/v1.0/history').success(function(data){
        var hist=data;
        His_store.setHis(hist);
        //console.log(hist);
        $scope.history=His_store.getHis();
    });
});

