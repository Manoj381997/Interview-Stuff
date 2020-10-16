from django.db.models.signals import post_save  # This signal gets fired when an obj is saved
from django.contrib.auth.models import User # this acts as sender
from django.dispatch import receiver    # Acts as receiver
from .models import Profile

@receiver(post_save, sender=User)
def create_profile(sender, instance, created, **kwargs):
    if created:
        Profile.objects.create(user=instance)

@receiver(post_save, sender=User)
def save_profile(sender, instance, **kwargs):   # **kwargs, is for any additional args
    instance.profile.save()