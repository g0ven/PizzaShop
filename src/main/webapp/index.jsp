<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page import="by.pizzasp.ics.mybatis.FinalPizzaMapper" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="utf-8">
    <title>pizzaShop</title>
    <link href="resources/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <link href="main.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>
    <script src="main.js"></script>
</head>
<body ng-app="rootApp" >
<h2>Pizzas</h2 >
<div id="fin1"   style="width: 300px; float:left">
    <table class="table" ng-controller="allFinCtrl"  >
        <tr>
            <th>name</th>
            <th>price</th>
            <th>ingredients</th>
            <th>order</th>
            <th> info</th>

        </tr>

        <tr ng-repeat="final in finalPizza | orderBy: 'id' ">
            <td>{{final.name}}</td>
            <td>{{final.price}}</td>
            <td>
                <table class="table">
                    <tr ng-repeat="inged in final.ingredientsDTO | orderBy: 'wage'" >
                        <td>{{inged.name}}</td>
                    </tr>
                </table>
            </td>
            <td><button ng-click="save(final.goodPizzaId,final.name,final.price);">order</button></td>
            <td>
                <div ng-controller="finIdCtrl">
                    <div>
                        <p>
                            <button ng-click="openDialog(final.goodPizzaId)">info</button>
                        </p>


                        <div id="popUpDialog-bg" ng-show="showPopUpDialog">
                            <div id="popUpDialog">
                                <div class="content">info about pizza</div>
                                <div>
                                    <p></p>
                                    <div><span>name: </span>{{finPizzId.name}}</div>
                                    <div><span>radius: </span>{{finPizzId.radius}}</div>
                                    <div>ingredients:</div>
                                    <div ng-repeat="ingred in finPizzId.ingredientsDTO | orderBy: 'wage'"> <span>name: {{ingred.name}}</span><span style="padding-left:30px">wage: {{ingred.wage}}</span>  </div>
                                    <div><span>wage: </span>{{finPizzId.wage}}</div>
                                    <div><span>price: </span>{{finPizzId.price}}</div>
                                </div>
                                <div class="clearfix buttons-container">
                                    <div class="pull-right">
                                        <button  ng-click="closePopUpDialog()">close</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </table>
</div>


<div id="bas1" style="margin-left:350px; width: 300px; float:left" >
    <h3>Basket</h3>
    <div ng-controller="basCtrl">
        <div ng-repeat="bask in basket">

            <span>{{bask.namePizza}}</span><span>{{bask.pricePerPizza}}</span>
            <button ng-click="removes($index,bask.goodPizzaId);">remove</button>
        </div>
        <button ng-click="order(basket);">order</button>



    </div>
</div>

<div ng-controller="addNewPizzaCtrl">
    <button ng-click="openDialogPizza()">new Pizza</button>
    <div id="popUpDialogPizza-bg" ng-show="showPopUpDialogPizza">
        <div id="popUpDialogPizza">
            <div class="content">new pizza</div>
            <div>
                <input ng-model="namePizza" type="text">name
                <select ng-model="keyBas" ng-options ="bas as bas.radius+'  V:'+bas.price+'  W:'+bas.wage for bas in basis">
                </select>
                <button ng-click="addNameAndRadius(keyBas,namePizza)">add</button>
                <div>

                    <select ng-model="keyIngred" ng-options ="ingred as ingred.name+'  V:'+ingred.pricePerKg  for ingred in ingredients">
                    </select>
                    <input ng-model="wageIngred" type="text">wage
                    <button ng-disabled="showAddIngr" ng-click="addIngredient(keyIngred,wageIngred)">add</button>
                </div>
                <p></p>
                <div><span>name: </span>{{finPizzId.name}}</div>
                <div><span>radius: </span>{{finPizzId.radius}}</div>
                <div>ingredients:</div>
                <div ng-repeat="ingred in finPizzId.ingredientsDTO | orderBy: 'wage'"> <span>name: {{ingred.name}}</span><span style="padding-left:30px">wage: {{ingred.wage}}</span>  </div>

            </div>
            <div class="clearfix buttons-container">
                <div class="pull-left">
                    <button  ng-click="createPizza()">create</button>
                </div>
                <div class="pull-right">
                    <button  ng-click="closePopUpDialogPizza()">close</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div style="margin-left:650px; width: 300px; float:left;">
    <h3>History</h3>
    <div ng-controller="hisCtrl">
        <div ng-repeat="hist in history | orderBy: 'timeOrder.valueOf()':true ">
            <span>{{hist.namePizza}}</span><span>({{hist.pricePerPizza}})</span><span>{{hist.timeOrder}}</span>
        </div>
    </div>
</div>
</body>
</html>