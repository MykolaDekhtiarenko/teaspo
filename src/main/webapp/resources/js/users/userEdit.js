/**
 * Created by PANNA on 01.03.2017.
 */
var app = angular.module('user_edit',[]);
FIELDS='fields=id,nikname,state,email';
LIMIT = 20;
app.controller('user_controller',function($scope,$http){
    var params = UrlUtil.parse(angular.element('#loader').attr('src'));
    params.id = parseInt(params.id);
    if(params.id){
        $http.get('/api/users/'+params.id+ '?FIELDS').then(function(response){
            if(response.data.result){
                $scope.user=response.data.result;
            }
        })
    }else{
        $scope.user={ };
    }
});

app.controller('user_edit_controller',function($scope,$http){
    $scope.userSave=function() {
        var _method = ($scope.user.id ? $http.post : $http.put);
        _method('/api/users/', JSON.stringify($scope.user), {headers: HEADERS}).then(function(response){
            var data=response.data;
            if(data.result){
                if(!$scope.user.id){
                    setTimeout(function() {
                        location.href = '/web/admin/' + data.result;
                    },2000);
                    }
                }
            },function(xhr){console.log(xht);});
        };
});