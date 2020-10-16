from django import forms
from django.forms import ModelForm, Textarea
from django.contrib.auth.models import User
from django.contrib.auth.forms import UserCreationForm
from .models import Profile

class UserRegisterForm(UserCreationForm):
    email = forms.EmailField()  # default is required=True, so we're not providing args

    class Meta: # Gives nested namespace for configs and keeps in one place
        model = User    # it is assigned it User Form
        fields = ['username', 'email', 'password1', 'password2']    # fields provided here are the ones displayed in UI Form in the same order

class UserUpdateForm(forms.ModelForm):
    email = forms.EmailField()

    class Meta:
        model = User
        fields = ['username', 'email']

class ProfileUpdateForm(forms.ModelForm):
    # bio = Textarea(attrs={'cols': 80, 'rows': 20})
    class Meta:
        model = Profile
        fields = ['image']